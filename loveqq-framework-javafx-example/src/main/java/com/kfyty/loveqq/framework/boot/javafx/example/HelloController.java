package com.kfyty.loveqq.framework.boot.javafx.example;

import com.kfyty.loveqq.framework.boot.javafx.example.model.User;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.Autowired;
import com.kfyty.loveqq.framework.core.autoconfig.annotation.EventListener;
import com.kfyty.loveqq.framework.core.event.GenericApplicationEvent;
import com.kfyty.loveqq.framework.core.lang.Lazy;
import com.kfyty.loveqq.framework.javafx.core.AbstractController;
import com.kfyty.loveqq.framework.javafx.core.annotation.FController;
import com.kfyty.loveqq.framework.javafx.core.annotation.FView;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * {@link FController} 标识是一个 fxml 控制器，并且是一个单例控制器
 * <p>
 * 添加 {@link com.kfyty.loveqq.framework.javafx.core.annotation.FPrototypeScope} 注解可标识一个原型作用域，每次新开窗口都创建新的窗口
 */
@Slf4j
@FController(value = "root", path = "/fxml/hello-view.fxml", title = "hello", main = true)
public class HelloController extends AbstractController<FlowPane> {
    /**
     * 文本框的 text 绑定到 user 对象的 name 属性
     */
    @FXML
    @FView("text:user.name")
    private TextField name;

    /**
     * 文本框的 text 绑定到 user 对象的 dept 属性中的 deptName 属性
     */
    @FXML
    @FView("text:user.dept.deptName")
    private TextField deptName;

    /**
     * 由于窗口的创建必须在 {@link javafx.application.Application#launch(String...)} 之后
     * 因此要使用自动注入，需要包装为 {@link Lazy} 进行懒注入
     * <p>
     * 新开窗口时，应调用 {@link Lazy#create()} 方法，具体创建新窗口还是返回原窗口，由 ioc 容器管理
     */
    @Autowired("newWindow")
    private Lazy<Stage> newWindow;

    /**
     * 要绑定的模型
     */
    private User user;

    /**
     * 事件监听机制
     */
    @EventListener
    public void onCloseNewWindow(GenericApplicationEvent<WindowEvent, String> event) {
        log.info("on close new window event: {}", event);
    }

    /**
     * 直接从模型中获取视图数据
     */
    @FXML
    protected void getFormData() {
        NewWindowController childController = this.getChildController(NewWindowController.class);
        log.info("{}, child form: {}", this.user, childController == null ? null : childController.getSelected().get());
    }

    /**
     * 打开新窗口并传值
     */
    @FXML
    protected void showSelectedWindow() {
        this.openWindow(NewWindowController.class, "deptNames.value[0]=dept1&deptNames.value[1]=dept2");
    }

    /**
     * 模型数据绑定异常回调
     */
    @Override
    public void onModelBindCause(ObservableValue<?> target, String bindPath, Object value, Throwable throwable) {
        log.error("{}: {}", target, throwable.getMessage());
    }

    /**
     * 子窗口关闭回调
     */
    @Override
    public void onChildClose(String name, Node child, AbstractController controller) {
        log.info("on child close name={}, window={}", name, controller.getWindow());

        /**
         * 设置子窗口选择的值
         */
        if (controller instanceof NewWindowController newWindowController) {
            this.user.getDept().setDeptName(newWindowController.getSelected().get());
        }
    }
}

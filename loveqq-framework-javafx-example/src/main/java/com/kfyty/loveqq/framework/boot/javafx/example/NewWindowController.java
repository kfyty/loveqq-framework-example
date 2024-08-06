package com.kfyty.loveqq.framework.boot.javafx.example;

import com.kfyty.loveqq.framework.core.event.GenericApplicationEvent;
import com.kfyty.loveqq.framework.core.lang.Value;
import com.kfyty.loveqq.framework.core.utils.IOC;
import com.kfyty.loveqq.framework.javafx.core.AbstractController;
import com.kfyty.loveqq.framework.javafx.core.annotation.FController;
import com.kfyty.loveqq.framework.javafx.core.annotation.FView;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例添加了 icon，可自动添加图片，或删除该属性
 */
@Slf4j
@FController(value = "newWindow", path = "/fxml/new-window.fxml", show = true, icon = "/icon/icon.ico")
public class NewWindowController extends AbstractController<AnchorPane> {
    /**
     * 列表数据绑定到 deptNames 属性
     * 列表选择的数据绑定到 selected 属性
     */
    @FXML
    @FView("items:deptNames.value")
    @FView(value = "getSelectionModel.selectedItemProperty:selected.value", method = true)
    private ListView<String> deptList;

    /**
     * 绑定模型
     * 基本数据类型需要使用 {@link Value} 包装
     */
    @Getter
    private final Value<List<String>> deptNames = new Value<>(new ArrayList<>());

    /**
     * 绑定模型
     * 基本数据类型需要使用 {@link Value} 包装
     */
    @Getter
    private Value<String> selected;

    private int cnt = 0;

    @FXML
    public void addDeptName() {
        this.deptNames.get().add("hello" + (++cnt));
    }

    @FXML
    protected void delChoose() {
        this.deptNames.get().remove(this.selected.get());
    }

    @FXML
    protected void closeWindow() {
        this.close();
    }

    /**
     * 窗口已显示回调
     */
    @Override
    public void onShown(WindowEvent event) {
        log.info("show new window");
    }

    /**
     * 本窗口关闭回调
     */
    @Override
    public void onClose(WindowEvent event) {
        log.info("publish close new window event: {}", this.window);
        IOC.publishEvent(new GenericApplicationEvent<>(event, "close window: " + this.window));
    }
}

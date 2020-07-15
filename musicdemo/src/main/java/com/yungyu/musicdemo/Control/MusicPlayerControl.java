package com.yungyu.musicdemo.Control;

import com.yungyu.musicdemo.utils.MusicPlayerUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

public class MusicPlayerControl {

    @FXML
    private Button btnStart;

    @FXML
    private void onStartBtnClick (ActionEvent event) throws InterruptedException {
        String text = btnStart.getText();
        if (text.equalsIgnoreCase("=")) {
            btnStart.setText("▲");
        } else {
            btnStart.setText("=");
        }
        String filePath = MusicPlayerControl.class.getResource("/music/001.mp3").getPath();
        MusicPlayerUtils.play(filePath);
    }

}

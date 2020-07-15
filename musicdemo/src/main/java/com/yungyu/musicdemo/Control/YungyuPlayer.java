package com.yungyu.musicdemo.Control;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.InputStream;

public class YungyuPlayer implements Runnable{

    private int framePos = -1;

    private AdvancedPlayer player;

    public YungyuPlayer (String filePath) {
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            player = new AdvancedPlayer(is);
            this.addListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public YungyuPlayer (String filePath, int framePos) {
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            player = new AdvancedPlayer(is);
            this.addListener();
            this.framePos = framePos;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addListener () {
        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackFinished(PlaybackEvent evt) {
                framePos = evt.getFrame();
            }

        });
    }

    public int stop () {
        player.stop();
        return framePos;
    }

    @Override
    public void run() {
        try {
            System.out.println(framePos);
            if (framePos > 0)
                player.play(0, framePos);
            else
                player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }
}

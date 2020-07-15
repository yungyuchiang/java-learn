package com.yungyu.musicdemo.utils;

import com.yungyu.musicdemo.Control.YungyuPlayer;

public class MusicPlayerUtils {

    private static YungyuPlayer player;

    private static int framePos = -1;

    public final static void play (String path) throws InterruptedException {
        if (null != player) {
            framePos = player.stop();
            player = null;
        } else {
            player = new YungyuPlayer(path, framePos);
            new Thread(player).start();
        }
    }

}

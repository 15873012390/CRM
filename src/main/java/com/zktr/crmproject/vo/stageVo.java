package com.zktr.crmproject.vo;

import java.sql.Timestamp;

public class stageVo {
    private int slId;
    private String slNote;
    private Timestamp recordTime;
    private String stageName;
    private String userName;

    public stageVo(int slId, String slNote, Timestamp recordTime, String stageName, String userName) {
        this.slId = slId;
        this.slNote = slNote;
        this.recordTime = recordTime;
        this.stageName = stageName;
        this.userName = userName;
    }

    public stageVo(String slNote, Timestamp recordTime, String stageName, String userName) {
        this.slNote = slNote;
        this.recordTime = recordTime;
        this.stageName = stageName;
        this.userName = userName;
    }
}

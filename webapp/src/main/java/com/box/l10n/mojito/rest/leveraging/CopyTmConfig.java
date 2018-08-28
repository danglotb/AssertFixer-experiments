package com.box.l10n.mojito.rest.leveraging;

import com.box.l10n.mojito.entity.PollableTask;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Configuration to start the copy TM process
 *
 * @author jaurambault
 */
public class CopyTmConfig {

    Long sourceRepositoryId;
    Long targetRepositoryId;
    Long targetAssetId;
    Long sourceAssetId;
    String nameRegex;

    Mode mode = Mode.MD5;

    PollableTask pollableTask;

    @JsonProperty
    public PollableTask getPollableTask() {
        return pollableTask;
    }

    /**
     * @JsonIgnore because this pollableTask is read only data generated by the
     * server side, it is not aimed to by external process via WS
     *
     * @param pollableTask
     */
    @JsonIgnore
    public void setPollableTask(PollableTask pollableTask) {
        this.pollableTask = pollableTask;
    }

    public Long getSourceRepositoryId() {
        return sourceRepositoryId;
    }

    public void setSourceRepositoryId(Long sourceRepositoryId) {
        this.sourceRepositoryId = sourceRepositoryId;
    }

    public Long getTargetRepositoryId() {
        return targetRepositoryId;
    }

    public void setTargetRepositoryId(Long targetRepositoryId) {
        this.targetRepositoryId = targetRepositoryId;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public String getNameRegex() {
        return nameRegex;
    }

    public void setNameRegex(String nameRegex) {
        this.nameRegex = nameRegex;
    }

    public Long getSourceAssetId() {
        return sourceAssetId;
    }

    public void setSourceAssetId(Long sourceAssetId) {
        this.sourceAssetId = sourceAssetId;
    }

    public Long getTargetAssetId() {
        return targetAssetId;
    }

    public void setTargetAssetId(Long targetAssetId) {
        this.targetAssetId = targetAssetId;
    }

    /**
     * Matching mode for leveraging
     */
    public enum Mode {
        /**
         * MD5 match means the message id, comment and content must be the same
         */
        MD5,
        /**
         * Exact match means the content must be the same (message id and
         * comment are not checked)
         */
        EXACT,
    }

}

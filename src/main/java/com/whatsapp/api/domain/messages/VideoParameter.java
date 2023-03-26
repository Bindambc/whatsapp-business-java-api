package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ParameterType;

/**
 * The type Video parameter.
 */
public class VideoParameter extends Parameter {
    @JsonProperty("video")
    private Video video;


    /**
     * Instantiates a new Parameter.
     */
    public VideoParameter() {
        super(ParameterType.VIDEO);
    }


    /**
     * Instantiates a new Video parameter.
     *
     * @param type  the type
     * @param video the video
     */
    public VideoParameter(ParameterType type, Video video) {
        super(type);
        this.video = video;
    }

    /**
     * Gets video.
     *
     * @return the video
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Sets video.
     *
     * @param video the video
     * @return the video
     */
    public VideoParameter setVideo(Video video) {
        this.video = video;
        return this;
    }
}

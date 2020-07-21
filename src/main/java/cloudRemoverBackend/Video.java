package cloudRemoverBackend;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.*;
import org.jcodec.common.model.Picture;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Video {
    private File videoFile;
    BufferedImage firstFrame;

    public Video(String pathToFile) throws IOException, JCodecException {
        videoFile = new File(pathToFile);

        Picture firstFramePreState = FrameGrab.getFrameFromFile(videoFile, 0);

        firstFrame = ImageIO.read((ImageInputStream) firstFramePreState);

    }

    public int getNumberOfFrames() throws IOException {
        Format f = JCodecUtil.detectFormat(videoFile);
        Demuxer d = JCodecUtil.createDemuxer(f, videoFile);
        DemuxerTrack vt = d.getVideoTracks().get(0);
        DemuxerTrackMeta dtm = vt.getMeta();

        return dtm.getTotalFrames();
    }

    public int getWidth() throws IOException, JCodecException {
        return firstFrame.getWidth();
    }

    public int getHeight() throws IOException, JCodecException {
        return firstFrame.getHeight();
    }

    public Picture getFrame(int frameNumber) throws IOException, JCodecException {
        return FrameGrab.getFrameFromFile(videoFile, frameNumber);
    }
}

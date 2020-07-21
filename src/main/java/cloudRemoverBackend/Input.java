package cloudRemoverBackend;


import org.jcodec.api.JCodecException;

import java.io.IOException;

public class Input {
    public static void remove (String pathToFile) throws IOException, JCodecException {

        Video inputVideo = new Video(pathToFile);

        System.out.println(inputVideo.getNumberOfFrames());

        System.out.println(inputVideo.getWidth());

        System.out.println(inputVideo.getFrame(5));

    }
}

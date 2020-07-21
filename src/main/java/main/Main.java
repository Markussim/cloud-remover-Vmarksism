package main;

import cloudRemoverBackend.Input;
import org.jcodec.api.JCodecException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, JCodecException {
        Input.remove("/home/markus/git/cloud-remover-Vmarkism/testFiles/122.mp4");
    }
}

package com.fi.mynlpapp;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * Created by smpathak on 4/20/17.
 */
public class SentenceDetectorUtil {
    InputStream modelIn = null;
    private SentenceModel sentenceModel = null;
    SentenceDetectorME sentenceDetector = null;
    String modelFile = "en-sent.bin";
    Context context;

    public SentenceDetectorUtil(Context ctx) {
        this.context = ctx;
        Objects.nonNull(modelFile);
        initSentenceModel();
    }

    private SentenceModel initSentenceModel() {
        try {
            modelIn = this.context.getAssets().open(modelFile);
            sentenceModel = new SentenceModel(modelIn);
            sentenceDetector = new SentenceDetectorME(sentenceModel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (modelIn != null) {
                try {
                    modelIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sentenceModel;
    }

    public String[] getSentences(String data) {
        return sentenceDetector.sentDetect(data);
    }
}

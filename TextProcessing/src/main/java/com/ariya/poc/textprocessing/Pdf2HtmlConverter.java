package com.ariya.poc.textprocessing;

import org.jpedal.examples.html.PDFtoHTML5Converter;
import org.jpedal.exception.PdfException;
import org.jpedal.render.output.ContentOptions;
import org.jpedal.render.output.ConversionOptions;
import org.jpedal.render.output.html.HTMLConversionOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by ariyabala on 29/03/16.
 */
public class Pdf2HtmlConverter {

    private static String outputHtmlFilePath; // Source dir for the file under which runtime folders like Downloaded, Html ..are created
    private static String inputPdfFilePath;

    Logger log = LoggerFactory.getLogger(Pdf2HtmlConverter.class);

    public static void main(String args[]) throws PdfException, IOException {
        HTMLConversionOptions opt = getHtmlConversionOptions();
        inputPdfFilePath = args[0];
        outputHtmlFilePath = args[1];
        File f = new File(inputPdfFilePath);
        if(f.isDirectory()){
            for(String file:f.list()){
                System.out.println("Converting " + inputPdfFilePath +"/"+file + " to Html");
                new PDFtoHTML5Converter(new File(inputPdfFilePath +"/"+file), new File(outputHtmlFilePath), opt, new ContentOptions()).convert();
            }
        }else{
            System.out.println("Converting " + inputPdfFilePath + " to Html");
            new PDFtoHTML5Converter(new File(inputPdfFilePath), new File(outputHtmlFilePath), opt, new ContentOptions()).convert();
        }
    }

    private static HTMLConversionOptions getHtmlConversionOptions(){
        HTMLConversionOptions opt = new HTMLConversionOptions();
        opt.setTextMode(HTMLConversionOptions.TextMode.SVG_REALTEXT);
        opt.setIncludedFonts(new ConversionOptions.Font[]{ConversionOptions.Font.OTF, ConversionOptions.Font.EOT, ConversionOptions.Font.WOFF});
        opt.setDisableComments(true);
        opt.setOmitNameDir(false);
        opt.setUseLegacyImageFileType(true);
        return opt;
    }
}

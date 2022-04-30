package imagesToPDF;

/**
 * @author Simon-the-coder
 * @date 12/12/21 6:04 PM
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JpgToPdf {
    public static void main(String arg[]) throws Exception {
        String rootPath = "/Users/simonhan/Documents/Projects/AndroidStudioProjects/flutter_tips/flutter-tips-and-tricks-main/images/";
        File root = new File(rootPath);
        String outputFile = "flutterTipsImages.pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File(root, outputFile)));
        document.open();

        File fa[] = root.listFiles();
        List<String> imageNameList = new ArrayList<String>();
        for (int i = 0; i < fa.length; i++) {
            imageNameList.add(fa[i].getName());
        }
        Collections.sort(imageNameList);
        int count = 0;
        for (String imageName : imageNameList) {
            if (!imageName.contains(".jpg") && !imageName.contains(".jpeg")) {
                continue;
            } else {
                System.out.println("Current Image Name ===> " + imageName);
                count++;
            }
            document.newPage();
            Image image = Image.getInstance(new File(root, imageName).getAbsolutePath());
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin()) / image.getWidth()) * 100;
            image.scalePercent(scaler);
            document.add(image);
        }

        document.close();
        System.out.println("DONE ----- count = " + count);
    }
}

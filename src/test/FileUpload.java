package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class FileUpload {
	public static void main(String args[]) {
		String inputFilePath = "D:\\seyoung\\dev\\source\\spring\\test\\src\\test\\input.txt";
		String outputFilePath = "expenses_output.csv"; // 출력 엑셀용 CSV 파일 경로

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_8)
        ) {
            writer.write("\uFEFF"); // BOM (Byte Order Mark) 추가하여 엑셀에서 한글 인코딩 문제 방지
            writer.write("지출내용,지출금액\n"); // CSV 헤더

            String line;
            String description = null;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("¥") && line.length() > 1 && Character.isDigit(line.charAt(1))) {
                    // \ 다음에 숫자가 오는 경우 -> 금액
                    String amount = line.substring(1); // \ 이후 부분 추출
                    if (description != null) {
                        writer.write(description + "," + amount + "\n");
                        description = null;
                    } else {
                        writer.write("," + amount + "\n");
                    }
                } else {
                    // 그 외 -> 지출 내용 저장
                    description = line;
                }
            }

            System.out.println("CSV 파일로 저장 완료: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("파일 처리 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

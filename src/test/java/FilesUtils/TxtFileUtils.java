package FilesUtils;

import Common.Constans;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TxtFileUtils {
    public static void saveDataToTxtFile(Map<String,Object> data, String fileName){
        FileWriter fos = null;
        BufferedWriter bw = null;
        try {
            File txtFile = new File(Constans.fileTxtPath +fileName);
            if (!txtFile.exists()){
                txtFile.createNewFile();
            }
            fos = new FileWriter(txtFile.getAbsoluteFile(),true);
            List<Object> dataItem = Arrays.asList(data.values().toArray());
            StringBuilder dataFile = new StringBuilder();
            for (int i = 0; i<dataItem.size(); i++) {
                dataFile.append(dataItem.get(i));
                if (i+1 < dataItem.size()){
                    dataFile.append(",");
                }
            }
            bw = new BufferedWriter(fos);
            bw.write("\n");
            bw.write(String.valueOf(dataFile));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (bw != null)
                    bw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Map<String,Object> getDataToTxtFile(String fileName,List<String> coloumnTable){
        Map<String,Object> data = new HashMap<>();
        try{
            FileInputStream fis = new FileInputStream(Constans.fileTxtPath +fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bfr = new BufferedReader(isr);
            String line = bfr.readLine();
            List<String> dataLine = new ArrayList<>();
            while(line != null){
                dataLine.add(line);
                line = bfr.readLine();

            }
            fis.close();
            isr.close();
            bfr.close();
            if (!dataLine.isEmpty()){
                String lastDataIndex = dataLine.get(dataLine.size()-1);
                if (!StringUtils.isBlank(lastDataIndex)){
                    List<String> dataWithColoumn = Arrays.stream(lastDataIndex.split(",")).collect(Collectors.toList());
                    for (int i =0 ; i<dataWithColoumn.size();i++) {
                        data.put(coloumnTable.get(i),dataWithColoumn.get(i));
                    }
                }
            }


        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return data;
    }
    public static void updateDataInTxtFile(Object[][] dataUpdate, String fileName){
        try{
            List<String> data = new ArrayList<>();
            List<String> dataUpdateList = new ArrayList<>();
            Object[][] dataInfile = null;
            FileInputStream fis = new FileInputStream(Constans.fileTxtPath +fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bfr = new BufferedReader(isr);
            String line = bfr.readLine();
            while(line != null){
                data.add(line);
                line = bfr.readLine();

            }
            fis.close();
            isr.close();
            bfr.close();
            for (int i = 0;i< dataUpdate.length;i++){
                StringBuilder dataItem = new StringBuilder();
                for (int j = 0;j< dataUpdate[i].length;j++){
                    dataItem.append(dataUpdate[i][j].toString());
                    if (j == dataUpdate[i].length-1){
                        dataItem.append(",");
                    }
                }
                dataUpdateList.add(dataItem.toString());
            }
            List<String> removeData = new ArrayList<>();
            for (String item :data) {
                if (dataUpdateList.contains(item)){
                    removeData.add(item);
                }
            }
            data.removeAll(removeData);
            Object[][] dataAfterUpdate = new Object[data.size()][];
            for (int i=0;i<data.size();i++){
                String[] array = data.get(i).split(",");
                for (int j=0;j<array.length;j++){
                    dataAfterUpdate[i][j] = array[j];
                }
            }
            //saveDataToTxtFile(dataAfterUpdate,fileName);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

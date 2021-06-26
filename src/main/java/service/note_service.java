package service;

import idao.inotedao;
import impledao.notedao;
import model.notemodel;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class note_service {

private final inotedao inotedao =new notedao();
    public note_service() {
    }

    public List<notemodel> gettop3(Object... parametters){

        List<notemodel> list = inotedao.gettop3(parametters);
        settime(list);

        return list;
    }
    public List<notemodel> getnotebyuserid(Object... parametters){

        String seach = parametters[0].toString();
        String returns = "%"+seach.trim()+"%";
        List<notemodel> list = inotedao.getnotebyuserid(returns,parametters[1]);
        settime(list);
        return list;
    }
    public void insertnote(Object... parameters){

        inotedao.insertnote(parameters);
    }

    public List<notemodel> seachnoteautomactic(Object... parametters){

        String seach = parametters[0].toString();
        String returns = "%"+seach.trim()+"%";
        List<notemodel>  list = inotedao.seachnoteautomactic(returns,parametters[1],parametters[2]);
        settime(list);

        return list;
    }


    public List<notemodel> getnotebyid(Object... parametters){

        List<notemodel> list = inotedao.getnotebyid(parametters);
        settime(list);
        return list;

    }
    public void updatenote(Object... parameters){

        inotedao.updatenote(parameters);

    }
    public void saveimage(Object... parameters){

        inotedao.saveimage(parameters);
    }





    private void settime(List<notemodel> notemodels){
        for (notemodel o : notemodels){
            Timestamp instant= Timestamp.from(Instant.now());
            long t= instant.getTime()-o.getCreatedatetime().getTime();
            long day=86400000;
            long hour=3600000;
            long phut=60000;

            if(t/day >=1){
                o.setTime(String.valueOf(t/day)+" ngày trước (khởi tạo)");
            }
            else if(t/hour>=1){
                o.setTime(String.valueOf(t/hour)+" tiếng trước (khởi tạo)");
            }
            else if(t/phut>=1){
                o.setTime(String.valueOf(t/phut)+" phút trước (khởi tạo)");
            }
            else {
                o.setTime("vài giây trước (khởi tạo)");
            }
            Timestamp timestamp =o.getEditdatetime();
            if(o.getEditdatetime()!=null){

                Timestamp instant1= Timestamp.from(Instant.now());
                long edittime = instant1.getTime()-o.getEditdatetime().getTime();
                if(edittime/day >=1){
                    o.setEdittime( "đã chỉnh sửa "+ String.valueOf(edittime/day)+" ngày trước");
                }
                else if(edittime/hour>=1){
                    o.setEdittime( "đã chỉnh sửa "+String.valueOf(edittime/hour)+" tiếng trước");
                }
                else if(edittime/phut>=1){
                    o.setEdittime( "đã chỉnh sửa "+String.valueOf(edittime/phut)+" phút trước");
                }
                else {
                    o.setEdittime(" mới chỉnh sửa vài giây trước");
                }
            }
        }


    }

}

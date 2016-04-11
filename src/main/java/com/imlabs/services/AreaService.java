package com.imlabs.services;
import java.util.*;

import com.imlabs.model.AreaMysql;


public interface AreaService {
     void insertArea(AreaMysql area);
     List<AreaMysql> findAllAreas();
     void deleteArea(long id);
     void updateArea(AreaMysql area);
     AreaMysql getAreaById(long id);

}

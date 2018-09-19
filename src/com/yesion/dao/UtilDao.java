package com.yesion.dao;

import com.yesion.pojo.ThePojo;

public interface UtilDao {
    boolean save(ThePojo pojo);

    boolean update(ThePojo pojo);
}

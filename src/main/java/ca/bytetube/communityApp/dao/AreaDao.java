package ca.bytetube.communityApp.dao;

import ca.bytetube.communityApp.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaDao {

    List<Area> queryArea();
}

package ca.sheridancollege.garzonba.assignment2.beans;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseAccess {
    private NamedParameterJdbcTemplate jdbcTemplate;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbcTemplate1) {
        this.jdbcTemplate = jdbcTemplate1;
    }

    public List<Mission> getMissionList() {
        String sql = "SELECT * FROM mission";

        MapSqlParameterSource namedParam = new MapSqlParameterSource();
        ArrayList<Mission> missionList = (ArrayList<Mission>) jdbcTemplate.query(sql, namedParam, new BeanPropertyRowMapper<Mission>(Mission.class));
        return missionList;
    }

    public int createMission(Mission mission) {
        String sql = "INSERT INTO mission (id,  agent, title, gadget1, gadget2) VALUES (:id, :agent, :title, :gadget1, :gadget2)";

        MapSqlParameterSource namedParam = new MapSqlParameterSource();
        namedParam.addValue("id", mission.getId());
        namedParam.addValue("agent", mission.getAgent());
        namedParam.addValue("title", mission.getTitle());
        namedParam.addValue("gadget1", mission.getGadget1());
        namedParam.addValue("gadget2", mission.getGadget2());

        int rowValue = jdbcTemplate.update(sql, namedParam);

        if (rowValue > 0) {
            System.out.println("Mission created");
        }

        return rowValue;
    }

    public void deleteMissionById(Long id) {
        String sql = "DELETE FROM mission WHERE id =:id";

        MapSqlParameterSource namedParam = new MapSqlParameterSource();
        namedParam.addValue("id", id);

        int r = jdbcTemplate.update(sql, namedParam);

        if (r > 0) {
            System.out.println("Deleted Mission " + id + " from database");
        }
    }

    public int updateMission(Mission mission) {
        String sql = "UPDATE mission SET agent=:agent, title=:title, gadget1=:gadget1, gadget2=:gadget2 WHERE id=:id";

        MapSqlParameterSource namedParam = new MapSqlParameterSource();
        namedParam.addValue("agent", mission.getAgent());
        namedParam.addValue("title", mission.getTitle());
        namedParam.addValue("gadget1", mission.getGadget1());
        namedParam.addValue("gadget2", mission.getGadget2());
        namedParam.addValue("id", mission.getId());

        int rowValue = jdbcTemplate.update(sql, namedParam);

        return rowValue;
    }

    public ArrayList<Mission> getMissionByName(String agent) {
        String sql = "SELECT * FROM mission WHERE agent=:agent";

        MapSqlParameterSource namedParam = new MapSqlParameterSource();
        namedParam.addValue("agent", agent);

        ArrayList<Mission> missionList = (ArrayList<Mission>) jdbcTemplate.query(sql, namedParam, new BeanPropertyRowMapper<Mission>(Mission.class));

        return missionList;
    }

    public Mission getMissionById(Long id) {
        String sql = "SELECT * FROM mission WHERE id=:id";

        MapSqlParameterSource namedParam = new MapSqlParameterSource();
        namedParam.addValue("id", id);

        BeanPropertyRowMapper<Mission> mapper = new BeanPropertyRowMapper<>(Mission.class);

        Mission mission = null;

        try {
            mission = jdbcTemplate.queryForObject(sql, namedParam, mapper);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Mission not found: " + id);
        }

        return mission;
    }
}

package com.qlsv.dao.impl;

import com.qlsv.dao.IScoreDAO;
import com.qlsv.mapper.impl.ScoreMapper;
import com.qlsv.model.ScoreModel;

import java.util.List;

public class ScoreDAO extends AbstractDAO<ScoreModel> implements IScoreDAO {
    @Override
    public List<ScoreModel> getAll() {
        String sql = "SELECT * FROM diem";
        return query(sql, new ScoreMapper());
    }

    @Override
    public Integer insert(ScoreModel score) {
        String sql = "INSERT INTO diem(diemgk, diemcc, diemck, diemtk, idsv, idhp)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        return insert(sql, score.getScore1(), score.getScore2(), score.getScore3(), score.getTotalScore(),
                score.getStudentID(), score.getSubjectID());
    }

    @Override
    public void update(ScoreModel score) {
        String sql = ("UPDATE diem SET diemGK = ?, diemCC = ?, diemCK = ?, diemTK = ? WHERE idD = ?");
        update(sql, score.getScore1(), score.getScore2(), score.getScore3(), score.getTotalScore(),
                score.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM diem WHERE idD = ?";
        update(sql, id);
    }

    @Override
    public ScoreModel getOneByID(int id) {
        String sql = "SELECT * FROM diem WHERE idD = ?";
        List<ScoreModel> list = query(sql, new ScoreMapper(), id);
        return list.size() == 1 ? list.get(0) : null;
    }

    @Override
    public List<ScoreModel> getAllByStudentID(int id) {
        String sql = "SELECT diem.*, soTinChi FROM diem INNER JOIN hocphan on diem.idHP = hocphan.idHP\n" +
                "WHERE idSV = ?";
        return query(sql, new ScoreMapper(), id);
    }

    @Override
    public List<ScoreModel> getAllBySubjectID(int id) {
        String sql = "SELECT * FROM diem WHERE idhp = ?";
        return query(sql, new ScoreMapper(), id);
    }
}

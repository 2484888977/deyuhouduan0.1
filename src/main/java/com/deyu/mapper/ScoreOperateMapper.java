package com.deyu.mapper;

import com.deyu.pojo.Score_view;
import com.deyu.pojo.Scoreoperation;
import com.deyu.pojo.Zlog_view;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreOperateMapper {
    List<Score_view> queryScoreView(@Param("page")int page, @Param("limit")int limit, @Param("Keyword") String Keyword);
    List<Score_view> queryScoreViewinfo();
    Score_view queryScoreViewid(@Param("id")int id);
    List<Zlog_view> queryZlogview(@Param("page")int page, @Param("limit")int limit, @Param("Keyword") String Keyword);
    List<Zlog_view> queryZlogviewinfo();
    //学分操作审核记录
    int editScoreoperation(Scoreoperation scoreoperation);
    //添加学分操作申请记录
    int addScoreoperation(Scoreoperation scoreoperation);
    //学生学分查询—学分加减记录
    List<Score_view> queryScoreViewStu(@Param("stuid")String stuid,@Param("stuname")String stuname);
//    Zlog_view queryZlogviewid();
}

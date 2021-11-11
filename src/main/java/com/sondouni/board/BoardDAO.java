package com.sondouni.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static int updBoard(BoardVO param){
        int num = 0;
        Connection con = null;
        PreparedStatement pr = null;
        String sql = " UPDATE t_board "+
                " SET title=?, writer =? , ctnt = ? "+
                " where iboard = ? ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setString(1, param.getTitle());
            pr.setString(2, param.getWriter());
            pr.setString(3, param.getCtnt());
            pr.setInt(4, param.getIboard());
            num = pr.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr);
        }
        return num;
    }
    public static BoardVO selBoard(BoardVO param){
        BoardVO vo = new BoardVO();
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = " SELECT * FROM t_board Where iboard = ? ";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            pr.setInt(1,param.getIboard());
            rs = pr.executeQuery();
            if(rs.next()){
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr,rs);
        }
        return vo;
    }
    public static int delBoard(BoardVO param){
        int num = 0;
        Connection con = null;
        PreparedStatement pre = null;
        String sql = " DELETE  from t_board where iboard = ? ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setInt(1,param.getIboard());
            num = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre);
        }
        return num;
    }
    public static List<BoardVO> selBoardList(){
        return selBoardList(null,null);
    }
    public static List<BoardVO> selBoardList(String key,String value){
        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql =" SELECT * FROM t_board where "+key+" like '%"+value+"%'";
        try {
            con = DButils.getCon();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()){
                BoardVO vo = new BoardVO();

                vo.setTitle(rs.getString("title"));
//                vo.setCtnt(rs.getString("ctnt"));
                vo.setRdt(rs.getString("rdt"));
                vo.setWriter(rs.getString("writer"));
                vo.setIboard(rs.getInt("iboard"));
                list.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pr,rs);
        }
        return list;
    }
    public static int insBoard(BoardVO param){
        int num = 0;
        Connection con = null;
        PreparedStatement pre = null;
        String sql = " INSERT INTO t_board (title,ctnt,writer) VALUES (?,?,?) ";
        try {
            con = DButils.getCon();
            pre = con.prepareStatement(sql);
            pre.setString(1,param.getTitle());
            pre.setString(2,param.getCtnt());
            pre.setString(3,param.getWriter());
            num = pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DButils.close(con,pre);
        }
        return num;
    }
}

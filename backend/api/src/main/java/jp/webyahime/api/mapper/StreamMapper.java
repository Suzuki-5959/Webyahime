package jp.webyahime.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.webyahime.api.dto.StreamDetailDto;
import jp.webyahime.api.dto.StreamListDto;
import jp.webyahime.api.entity.StreamEntity;

/**
 * 配信情報に関するMapperインターフェース
 */
@Mapper
public interface StreamMapper {

    /**
     * 配信情報を新規登録するメソッド
     * 
     * @param streamEntity 必須情報を格納した配信情報Entity
     * @return 登録された配信情報のID
     */
    long create(StreamEntity streamEntity);

    /**
     * 指定したユーザーの配信情報リストを取得するメソッド
     * 
     * @param userId 取得対象のユーザーID
     * @return 対象のユーザーの配信情報(配信ID、タイトル、カテゴリ名称、登録日時)リスト
     */
    List<StreamListDto> findByUserId(String userId);

    /**
     * 指定した配信IDの配信情報を取得するメソッド
     * 
     * @param streamId 取得対象の配信ID
     * @return 対象IDの配信情報(配信ID、タイトル、概要、カテゴリ名称、登録日時)
     */
    StreamDetailDto findByStreamId(long streamId);

    /**
     * 指定した配信IDの配信情報を論理削除するメソッド
     * 
     * @param streamId 削除対象の配信ID
     */
    long delete(long streamId);

}

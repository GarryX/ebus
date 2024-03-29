package com.athome.ebusiness.mybatis.client;

import com.athome.ebusiness.mybatis.domain.ContractProductC;
import com.athome.ebusiness.mybatis.domain.ContractProductCExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractProductCMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int countByExample(ContractProductCExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int deleteByExample(ContractProductCExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int deleteByPrimaryKey(String contractProductId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int insert(ContractProductC record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int insertSelective(ContractProductC record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    List<ContractProductC> selectByExample(ContractProductCExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    ContractProductC selectByPrimaryKey(String contractProductId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int updateByExampleSelective(@Param("record") ContractProductC record, @Param("example") ContractProductCExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int updateByExample(@Param("record") ContractProductC record, @Param("example") ContractProductCExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int updateByPrimaryKeySelective(ContractProductC record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract_product_c
     *
     * @mbggenerated Mon May 30 11:12:13 CST 2016
     */
    int updateByPrimaryKey(ContractProductC record);
}
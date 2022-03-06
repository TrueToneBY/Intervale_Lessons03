/*
 * partner.public
 * API для работы с публичными методами
 *
 * OpenAPI spec version: 1.0.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.intervale.cources.library.external.alfabank.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Rate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Выходная модель, содержащая основные курсы валют Альфа-Банка
 */

public class RateListResponse {

  private List<Rate> rates = null;

  public RateListResponse rates(List<Rate> rates) {
    this.rates = rates;
    return this;
  }

  public RateListResponse addRatesItem(Rate ratesItem) {
    if (this.rates == null) {
      this.rates = new ArrayList<Rate>();
    }
    this.rates.add(ratesItem);
    return this;
  }

   /**
   * Список основных курсов валют Альфа-Банка
   * @return rates
  **/

  public List<Rate> getRates() {
    return rates;
  }

  public void setRates(List<Rate> rates) {
    this.rates = rates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RateListResponse rateListResponse = (RateListResponse) o;
    return Objects.equals(this.rates, rateListResponse.rates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rates);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RateListResponse {\n");
    
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


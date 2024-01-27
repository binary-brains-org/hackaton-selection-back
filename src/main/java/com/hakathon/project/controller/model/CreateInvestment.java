package com.hakathon.project.controller.model;

import com.hakathon.project.model.InvestmentCategory;
import com.hakathon.project.model.enums.InvestmentEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Builder
@Getter
@Setter
public class CreateInvestment {
  String id;
  String name;
  String comment;
  InvestmentEnum.Status status;
  int price;
  String image;
  List<InvestmentCategory> category;
}

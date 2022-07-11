package screens;

public class Columns {

   static String[] columns_benefits_cost_sharing = {"businessyear", "statecode", "issuerid", "sourcename", "importdate", "standardcomponentid", "planid",
            "benefitname", "copayinntier1", "copayinntier2", "copayoutofnet", "coinsinntier1", "coinsinntier2", "coinsoutofnet", "isehb", "iscovered",
            "quantlimitonsvc", "limitqty", "limitunit", "exclusions", "explanation", "ehbvarreason", "isexclfrominnmoop", "isexclfromoonmoop"};

  static   String[] columns_business_rules = {"businessyear", "statecode", "issuerid", "sourcename", "importdate", "tin",
            "productid", "standardcomponentid", "enrolleecontractratedeterminationrule", "twoparentfamilymaxdependentsrule",
            "singleparentfamilymaxdependentsrule", "dependentmaximumagrule", "childrenonlycontractmaxchildrenrule",
            "domesticpartnerasspouseindicator", "samesexpartnerasspouseindicator", "agedeterminationrule", "minimumtobaccofreemonthsrule",
            "cohabitationrule", "marketcoverage", "dentalonlyplan"};

  static   String[] columns_plan_attributes = {"businessyear", "statecode", "issuerid", "sourcename", "importdate",
            "marketcoverage", "dentalonlyplan", "tin", "standardcomponentid", "planmarketingname", "hiosproductid",
            "hpid", "networkid", "serviceareaid", "formularyid", "isnewplan", "plantype", "metallevel", "designtype", "uniqueplandesign",
            "qhpnonqhptypeid", "isnoticerequiredforpregnancy", "isreferralrequiredforspecialist", "specialistrequiringreferral",
            "planlevelexclusions", "indianplanvariationestimatedadvancedpaymentamountperenrollee", "compositeratingoffered",
            "childonlyoffering", "childonlyplanid", "wellnessprogramoffered", "diseasemanagementprogramsoffered", "ehbpercenttotalpremium", "ehbpediatricdentalapportionmentquantity", "isguaranteedrate", "planeffectivedate", "planexpirationdate",
            "outofcountrycoverage", "outofcountrycoveragedescription", "outofserviceareacoverage", "outofserviceareacoveragedescription", "nationalnetwork", "urlforenrollmentpayment", "formularyurl", "planid",
            "planvariantmarketingname", "csrvariationtype", "issueractuarialvalue", "avcalculatoroutputnumber", "medicaldrugdeductiblesintegrated", "medicaldrugmaximumoutofpocketintegrated" ,
            "multipleinnetworktiers" , "firsttierutilization" , "secondtierutilization" , "sbchavingababydeductible" , "sbchavingababycopayment" , "sbchavingababycoinsurance" , "sbchavingababylimit" , "sbchavingdiabetesdeductible" , "sbchavingdiabetescopayment" , "sbchavingdiabetescoinsurance" , "sbchavingdiabeteslimit" , "sbchavingsimplefracturedeductible" , "sbchavingsimplefracturecopayment" , "sbchavingsimplefracturecoinsurance" , "sbchavingsimplefracturelimit" , "specialtydrugmaximumcoinsurance" , "inpatientcopaymentmaximumdays" , "beginprimarycarecostsharingafternumberofvisits" , "beginprimarycaredeductiblecoinsuranceafternumberofcopays" , "mehbinntier1individualmoop" , "mehbinntier1familyperpersonmoop" , "mehbinntier1familypergroupmoop" , "mehbinntier2individualmoop" , "mehbinntier2familyperpersonmoop" , "mehbinntier2familypergroupmoop" , "mehboutofnetindividualmoop" , "mehboutofnetfamilyperpersonmoop" , "mehboutofnetfamilypergroupmoop" , "mehbcombinnoonindividualmoop" , "mehbcombinnoonfamilyperpersonmoop" , "mehbcombinnoonfamilypergroupmoop" , "dehbinntier1individualmoop" , "dehbinntier1familyperpersonmoop" , "dehbinntier1familypergroupmoop" , "dehbinntier2individualmoop" , "dehbinntier2familyperpersonmoop" , "dehbinntier2familypergroupmoop" , "dehboutofnetindividualmoop" , "dehboutofnetfamilyperpersonmoop" , "dehboutofnetfamilypergroupmoop" , "dehbcombinnoonindividualmoop" , "dehbcombinnoonfamilyperpersonmoop" ,
            "dehbcombinnoonfamilypergroupmoop" , "tehbinntier1individualmoop" , "tehbinntier1familyperpersonmoop" , "tehbinntier1familypergroupmoop" , "tehbinntier2individualmoop" , "tehbinntier2familyperpersonmoop" , "tehbinntier2familypergroupmoop" , "tehboutofnetindividualmoop" , "tehboutofnetfamilyperpersonmoop" ,
            "tehboutofnetfamilypergroupmoop" , "tehbcombinnoonindividualmoop" , "tehbcombinnoonfamilyperpersonmoop" , "tehbcombinnoonfamilypergroupmoop" , "mehbdedinntier1individual" ,
            "mehbdedinntier1familyperperson" , "mehbdedinntier1familypergroup" , "mehbdedinntier1coinsurance" ,
            "mehbdedinntier2individual" , "mehbdedinntier2familyperperson" , "mehbdedinntier2familypergroup" , "mehbdedinntier2coinsurance" , "mehbdedoutofnetindividual" , "mehbdedoutofnetfamilyperperson" , "mehbdedoutofnetfamilypergroup" , "mehbdedcombinnoonindividual" , "mehbdedcombinnoonfamilyperperson" , "mehbdedcombinnoonfamilypergroup" , "dehbdedinntier1individual" , "dehbdedinntier1familyperperson" , "dehbdedinntier1familypergroup" ,"dehbdedinntier1coinsurance" , "dehbdedinntier2individual" , "dehbdedinntier2familyperperson" , "dehbdedinntier2familypergroup" , "dehbdedinntier2coinsurance" , "dehbdedoutofnetindividual" , "dehbdedoutofnetfamilyperperson" , "dehbdedoutofnetfamilypergroup" , "dehbdedcombinnoonindividual" , "dehbdedcombinnoonfamilyperperson" , "dehbdedcombinnoonfamilypergroup" , "tehbdedinntier1individual" , "tehbdedinntier1familyperperson" , "tehbdedinntier1familypergroup" , "tehbdedinntier1coinsurance" , "tehbdedinntier2individual" , "tehbdedinntier2familyperperson" , "tehbdedinntier2familypergroup" , "tehbdedinntier2coinsurance" , "tehbdedoutofnetindividual" , "tehbdedoutofnetfamilyperperson" , "tehbdedoutofnetfamilypergroup" , "tehbdedcombinnoonindividual" , "tehbdedcombinnoonfamilyperperson" , "tehbdedcombinnoonfamilypergroup" , "ishsaeligible" , "hsaorhraemployercontribution" , "hsaorhraemployercontributionamount" , "urlforsummaryofbenefitscoverage" , "planbrochure"};

 static    String[] columns_rate={
            "businessyear", "statecode", "issuerid", "sourcename","importdate", "federaltin", "rateeffectivedate", "rateexpirationdate", "planid", "ratingareaid", "tobacco", "age",
            "individualrate", "individualtobaccorate", "couple", "primarysubscriberandonedependent", "primarysubscriberandtwodependents", "primarysubscriberandthreeormoredependents", "coupleandonedependent", "coupleandtwodependents",
            "coupleandthreeormoredependents"
    };
}

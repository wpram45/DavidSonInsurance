package screens;

import database.PostgreSQLJDBC;

import utils.Localization;
import utils.SizeUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowTable extends JDialog {
    private JTable table1;
    private JPanel panelMain;
    private JScrollPane ScrollPane;
    private JButton DrawGraph;
    private String tableName;
    SizeUtils sizeUtil = new SizeUtils();

    DrawGraphs drawGraphs=new DrawGraphs();

    DefaultTableModel modelim = new DefaultTableModel();

    String[] columns_benefits_cost_sharing = {"businessyear", "statecode", "issuerid", "sourcename", "importdate", "standardcomponentid", "planid",
            "benefitname", "copayinntier1", "copayinntier2", "copayoutofnet", "coinsinntier1", "coinsinntier2", "coinsoutofnet", "isehb", "iscovered",
            "quantlimitonsvc", "limitqty", "limitunit", "exclusions", "explanation", "ehbvarreason", "isexclfrominnmoop", "isexclfromoonmoop"};

    String[] columns_business_rules = {"businessyear", "statecode", "issuerid", "sourcename", "importdate", "tin",
            "productid", "standardcomponentid", "enrolleecontractratedeterminationrule", "twoparentfamilymaxdependentsrule",
            "singleparentfamilymaxdependentsrule", "dependentmaximumagrule", "childrenonlycontractmaxchildrenrule",
            "domesticpartnerasspouseindicator", "samesexpartnerasspouseindicator", "agedeterminationrule", "minimumtobaccofreemonthsrule",
            "cohabitationrule", "marketcoverage", "dentalonlyplan"};

    String[] columns_plan_attributes = {"businessyear", "statecode", "issuerid", "sourcename", "importdate",
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

    String[] columns_rate={
            "businessyear", "statecode", "issuerid", "sourcename","importdate", "federaltin", "rateeffectivedate", "rateexpirationdate", "planid", "ratingareaid", "tobacco", "age",
            "individualrate", "individualtobaccorate", "couple", "primarysubscriberandonedependent", "primarysubscriberandtwodependents", "primarysubscriberandthreeormoredependents", "coupleandonedependent", "coupleandtwodependents",
            "coupleandthreeormoredependents"
    };
    Object[] rows = new Object[24];






    public ShowTable() {
        setTitle("Show data as TABLE");


        Dimension defaultSize = new Dimension((int) (sizeUtil.getWidth() / 1.5), (int) (sizeUtil.getHeight() - 100));

        setContentPane(panelMain);
        this.setSize(defaultSize);
        setLocationRelativeTo(null);
        this.setResizable(true);


        //make visible false after
        setVisible(false);

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        addListeners();


    }

    private  void addListeners(){

        DrawGraph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {




                drawGraphs.setLocalization();
                drawGraphs.setVisible(true);


            }
        });

    }

    private void addRowsTablePlanAttributes() {

        //152 column
        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);

            rows = new Object[columns_plan_attributes.length];



        try {
            while (rs.next()) {



                for(int i=0;i<columns_plan_attributes.length;i++){
                    rows[i] = rs.getString(columns_plan_attributes[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private void addRowsTableRate() {

        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);

        rows = new Object[columns_rate.length];



        try {
            while (rs.next()) {

                for(int i=0;i< columns_rate.length;i++){
                    rows[i] = rs.getString(columns_rate[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void addRowsTableBusinessRules() {

        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);

        rows = new Object[columns_business_rules.length];

      //  System.out.println(columns_business_rules.length);

        try {
            while (rs.next()) {

                for(int i=0;i<columns_business_rules.length;i++){
                    rows[i] = rs.getString(columns_business_rules[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            System.out.println("hata");
            e.printStackTrace();
        }


    }


    private void addRowsToTableBenefits_cost_sharing() {

        ResultSet rs = PostgreSQLJDBC.selectAllFromTable(tableName);
        rows = new Object[columns_benefits_cost_sharing.length];

        try {


            while (rs.next()) {


                for(int i=0;i< columns_benefits_cost_sharing.length;i++){
                    rows[i] = rs.getString(columns_benefits_cost_sharing[i]);
                }



                modelim.addRow(rows);


            }


            table1.setModel(modelim);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {

        modelim.setColumnCount(0);
        modelim.setRowCount(0);


        switch (tableName) {

            case "benefits_cost_sharing":
                this.tableName = tableName;
                modelim.setColumnIdentifiers(columns_benefits_cost_sharing);
                addRowsToTableBenefits_cost_sharing();
                break;

            case "business_rules":
                modelim.setColumnIdentifiers(columns_business_rules);
                this.tableName = tableName;
                addRowsTableBusinessRules();
                break;
            case "plan_attributes":
                modelim.setColumnIdentifiers(columns_plan_attributes);
                this.tableName = tableName;
                addRowsTablePlanAttributes();
                break;
            case "rate":
                modelim.setColumnIdentifiers(columns_rate);
                this.tableName = tableName;
               addRowsTableRate();
                break;



        }


    }
}

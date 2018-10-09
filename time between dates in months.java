 //Final
    FLOOR(100*(if(
      DAY(End_Date__c) >= DAY(Start_Date__c),
     (
       (12*(YEAR(End_Date__c) - YEAR(Start_Date__c)))+
       (MONTH(End_Date__c) - MONTH(Start_Date__c))+
       ((DAY(End_Date__c) - DAY(Start_Date__c))/30)
       ),
     (
       (12*(YEAR(End_Date__c) - YEAR(Start_Date__c)))+
       ((MONTH(End_Date__c) - MONTH(Start_Date__c))-1)+
       ((if(
        MONTH(Start_Date__c) = 2,
        if(
          OR(
            MOD( YEAR(Start_Date__c), 400 ) = 0,
            AND(
             MOD( YEAR( Start_Date__c ), 4 ) = 0,
             MOD( YEAR( Start_Date__c ), 100 ) != 0
             )
            ),
          28,
          29
          ),
         DAY(ADDMONTHS(DATE(YEAR(Start_Date__c), MONTH(Start_Date__c), 01),1) -1) 
       )-(DAY(Start_Date__c)) + DAY(End_Date__c) +1)/30)
       )
     )))/100
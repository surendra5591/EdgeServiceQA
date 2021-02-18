package POC_TestCases;

public class HybrideRule {
	
	String Hybrideruleconfig="";
	
public void CreateHybrideRuleConfig() {
	
	String HybridPayload="{ \r\n" + 
			"   \"configurationId\":\"configurationId101\",\r\n" + 
			"   \"configurationName\":\""+Hybrideruleconfig+"\",\r\n" + 
			"   \"ruleAssociation\":[ \r\n" + 
			"      { \r\n" + 
			"         \"rule\":{ \r\n" + 
			"            \"tenantId\":\"86d47035-3d37-4f55-a08a-a21e7318d6e2\",\r\n" + 
			"            \"ruleId\":\"d583a6ac-fbe2-47e5-8f59-bde4af498dda\",\r\n" + 
			"            \"ruleName\":\"MyRuleTesting228\",\r\n" + 
			"            \"activationId\":\"3ed11ad5-4054-4bc9-9ed8-6f3024563ef8\",\r\n" + 
			"            \"ruleType\":\"HYBRID\",\r\n" + 
			"            \"target\":\"EDGE\",\r\n" + 
			"            \"activate\":true,\r\n" + 
			"            \"ruleArtifact\":{ \r\n" + 
			"                 \"brmRuleSet\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\r\\n<ruleset activatehigherpriorityrule=\\\"true\\\" aliasname=\\\"\\\" effectivedate=\\\"Always\\\" expirationdate=\\\"\\\" groupingreason=\\\"\\\" guid=\\\"c76a83903c864135af24d652faad155a\\\" isreusable=\\\"false\\\" mainflowguid=\\\"\\\" mainflowname=\\\"\\\" name=\\\"VocabularyName_1562575817016_20190708105017605::StreamRuleName_1562575834148\\\" persistent=\\\"false\\\" projectname=\\\"\\\" type=\\\"FlowRuleset\\\" varaliasname=\\\"\\\" version=\\\"1\\\">\\r\\n<task guid=\\\"a5e133ee1ae0454fb051bd51f582691d\\\">\\r\\n<name value=\\\"StreamRuleName_1562575834148_20190708105036326\\\"/>\\r\\n<taskaction>\\r\\n  <conditional-ta>\\r\\n    <if-block-ta>\\r\\n      <simplefact comparator=\\\"Equals\\\">\\r\\n        <lvalue>\\r\\n          <simpleexp closebracket=\\\"0\\\" javatype=\\\"double\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n            <doreference attname=\\\"Pressure\\\" do=\\\"timeSeriesDOName\\\" operation=\\\"get\\\"/>\\r\\n          </simpleexp>\\r\\n        </lvalue>\\r\\n        <rvalue>\\r\\n          <simpleexp closebracket=\\\"0\\\" javatype=\\\"double\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n            <primitive value=\\\"101\\\"/>\\r\\n          </simpleexp>\\r\\n        </rvalue>\\r\\n      </simplefact>\\r\\n      <taskaction>\\r\\n        <execute-ta>\\r\\n          <simpleexp closebracket=\\\"0\\\" javatype=\\\"\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n            <doreference attname=\\\"IoT_Event_Name\\\" do=\\\"Result_Stream\\\" operation=\\\"set\\\">\\r\\n              <argument isGenericsArg=\\\"false\\\" isVarArg=\\\"false\\\" name=\\\"\\\" type=\\\"\\\">\\r\\n                <simpleexp closebracket=\\\"0\\\" javatype=\\\"java.lang.String\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n                  <primitive value=\\\"NewEvent\\\"/>\\r\\n                </simpleexp>\\r\\n              </argument>\\r\\n            </doreference>\\r\\n          </simpleexp>\\r\\n        </execute-ta>\\r\\n      </taskaction>\\r\\n      <taskaction>\\r\\n        <execute-ta>\\r\\n          <simpleexp closebracket=\\\"0\\\" javatype=\\\"\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n            <doreference attname=\\\"IoT_Event_Severity\\\" do=\\\"Result_Stream\\\" operation=\\\"set\\\">\\r\\n              <argument isGenericsArg=\\\"false\\\" isVarArg=\\\"false\\\" name=\\\"\\\" type=\\\"\\\">\\r\\n                <simpleexp closebracket=\\\"0\\\" javatype=\\\"java.lang.String\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n                  <primitive value=\\\"high\\\"/>\\r\\n                </simpleexp>\\r\\n              </argument>\\r\\n            </doreference>\\r\\n          </simpleexp>\\r\\n        </execute-ta>\\r\\n      </taskaction>\\r\\n      <taskaction>\\r\\n        <execute-ta>\\r\\n          <simpleexp closebracket=\\\"0\\\" javatype=\\\"\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n            <doreference attname=\\\"IoT_Rule_ID\\\" do=\\\"Result_Stream\\\" operation=\\\"set\\\">\\r\\n              <argument isGenericsArg=\\\"false\\\" isVarArg=\\\"false\\\" name=\\\"\\\" type=\\\"\\\">\\r\\n                <simpleexp closebracket=\\\"0\\\" javatype=\\\"java.lang.String\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n                  <primitive value=\\\"d583a6ac-fbe2-47e5-8f59-bde4af498dda\\\"/>\\r\\n                </simpleexp>\\r\\n              </argument>\\r\\n            </doreference>\\r\\n          </simpleexp>\\r\\n        </execute-ta>\\r\\n      </taskaction>\\r\\n    </if-block-ta>\\r\\n    <else-block-ta>\\r\\n      <taskaction>\\r\\n        <execute-ta>\\r\\n          <simpleexp closebracket=\\\"0\\\" javatype=\\\"\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n            <doreference attname=\\\"IoT_Rule_ID\\\" do=\\\"Result_Stream\\\" operation=\\\"set\\\">\\r\\n              <argument isGenericsArg=\\\"false\\\" isVarArg=\\\"false\\\" name=\\\"\\\" type=\\\"\\\">\\r\\n                <simpleexp closebracket=\\\"0\\\" javatype=\\\"java.lang.String\\\" openbracket=\\\"0\\\" operator=\\\"\\\">\\r\\n                  <primitive value=\\\"d583a6ac-fbe2-47e5-8f59-bde4af498dda\\\"/>\\r\\n                </simpleexp>\\r\\n              </argument>\\r\\n            </doreference>\\r\\n          </simpleexp>\\r\\n        </execute-ta>\\r\\n      </taskaction>\\r\\n    </else-block-ta>\\r\\n  </conditional-ta>\\r\\n</taskaction>\\r\\n</task>\\r\\n<reusedresources/>\\r\\n</ruleset>\"\r\n" + 
			"            },\r\n" + 
			"            \"ermRuleServiceId\":\"c197133bd4d74655babf41782c66c018\",\r\n" + 
			"            \"brmRuleSetName\":\"VocabularyName_1562575817016_20190708105017605::StreamRuleName_1562575834148\",\r\n" + 
			"            \"parameters\":{ \r\n" + 
			"               \"assignments\":[ \r\n" + 
			"                  { \r\n" + 
			"                     \"objectType\":\"com.sap.appiot.PropertySetType\",\r\n" + 
			"                     \"objectId\":\"rules.sandbox02.rules:MultiVocTimeSeries\"\r\n" + 
			"                  },\r\n" + 
			"                  { \r\n" + 
			"                     \"objectType\":\"com.sap.appiot.ThingType\",\r\n" + 
			"                     \"objectId\":\"rules.sandbox02.rules:MultiVocThingType\"\r\n" + 
			"                  },\r\n" + 
			"                  { \r\n" + 
			"                     \"objectType\":\"com.sap.appiot.PropertySet\",\r\n" + 
			"                     \"objectId\":\"timeSeriesData\"\r\n" + 
			"                  }\r\n" + 
			"               ],\r\n" + 
			"               \"isToggle\":false,\r\n" + 
			"               \"sleepingTimeFrame\":\"PT1H\",\r\n" + 
			"               \"timeFrame\":null,\r\n" + 
			"               \"scheduling\":null\r\n" + 
			"            },\r\n" + 
			"            \"dataObjects\":[ \r\n" + 
			"               { \r\n" + 
			"                  \"name\":\"timeSeriesDOName\",\r\n" + 
			"                  \"type\":\"TimeSeriesData\",\r\n" + 
			"                  \"key\":{ \r\n" + 
			"                     \"thingType\":\"rules.sandbox02.rules:MultiVocThingType\",\r\n" + 
			"                     \"propertySet\":\"timeSeriesData\",\r\n" + 
			"                     \"id\":null\r\n" + 
			"                  },\r\n" + 
			"                  \"usedAttributes\":[ \r\n" + 
			"                     \"Pressure\",\r\n" + 
			"                     \"Text\",\r\n" + 
			"                     \"Temperature\"\r\n" + 
			"                  ],\r\n" + 
			"                  \"threshold\":null\r\n" + 
			"               }\r\n" + 
			"            ]\r\n" + 
			"         },\r\n" + 
			"         \"usedRuleAttributes\":[\"Pressure\"],\r\n" + 
			"         \"actions\":[ \r\n" + 
			"            { \r\n" + 
			"               \"id\":\"Create FSM for Compressor too hot\",\r\n" + 
			"               \"source\":\"Edge\"\r\n" + 
			"            }\r\n" + 
			"         ],\r\n" + 
			"         \"sensorTypeMappings\":{  \r\n" + 
			"           \"results\":[  \r\n" + 
			"            {  \r\n" + 
			"              \"mappingId\":\"<MAPPPING_ID1>\",\r\n" + 
			"              \"name\":\"<MAPPPING_NAME>\",\r\n" + 
			"              \"thingTypeName\":\"rules.sandbox02.rules:MultiVocThingType\",\r\n" + 
			"              \"measureMappings\":{  \r\n" + 
			"                \"results\":[  \r\n" + 
			"                  {  \r\n" + 
			"                    \"mappingId\":\"<MAPPPING_ID1>\",\r\n" + 
			"                    \"sensorTypeName\":\"Sentyp2108_1050\",\r\n" + 
			"                    \"sensorTypeId\":\"38\",\r\n" + 
			"                    \"capabilityName\":\"Cap2108_1050\",\r\n" + 
			"                    \"capabilityId\":\"43672678-a030-4629-879d-5022258af190\",\r\n" + 
			"                    \"capabilityPropertyId\":\"Longitude\",\r\n" + 
			"                    \"thingTypeName\":\"rules.sandbox02.rules:MultiVocThingType\",\r\n" + 
			"                    \"propertySetTypeId\":\"timeSeriesData_PST\",\r\n" + 
			"                    \"namedPropertySetTypeId\":\"timeSeriesData\",\r\n" + 
			"                    \"namedPropertySetTypePropertyId\":\"Pressure\"\r\n" + 
			"                  }\r\n" + 
			"               ]\r\n" + 
			"             }\r\n" + 
			"           }\r\n" + 
			"         ]\r\n" + 
			"       }\r\n" + 
			"\r\n" + 
			"      }\r\n" + 
			"   ]\r\n" + 
			"}\r\n" + 
			"";
		
	}

}

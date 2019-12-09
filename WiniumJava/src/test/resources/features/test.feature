#Author: pritam.maibam@gmail.com
Feature: This is sample test feature for training purpose 

@smk 
Scenario Outline: TC0001 - Simple application Login 

	Given test case number <tcNo> 
	When user click on create google account 
	Then user enter <firstName> <lastName> <userName> <pwd> 
	#And user enters <month> <day> <year> and <gender> 
	
	Examples: 
		|firstName|lastName|userName|pwd|month|day|year|gender|tcNo|
		|mytestAuto|Sel|mytestAuto2104|Autotest@123|July|20|1990|Male|TC-1001|
		

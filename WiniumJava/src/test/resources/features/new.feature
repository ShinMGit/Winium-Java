#Author: pritam.maibam@gmail.com
Feature: This is sample test feature for training purpose 

Scenario Outline: Test 1 - Simple application Login 

	Given user launch the application 
	When user login to the application 
	Then verify home page 
	And perform some actions 
	
	Examples: 
		|userName|password|item|
		|abc|123|newItem|
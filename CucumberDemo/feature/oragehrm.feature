Feature: Orange hrm login

Scenario: simple login
	Given I launch chrome browser
	And I open ornage hrm homepage
	When Enter username and password
	And Click on login button
	Then User must succefully login to the dashboard
	And Closed browser
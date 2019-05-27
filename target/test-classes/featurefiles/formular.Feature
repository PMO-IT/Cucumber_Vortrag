Feature: Enter valid Data

Scenario: Enter valid data and send form without error
	Given User navigates to form website
	And User fills in Data
	When User clicks on the ok button
	Then User should be taken to the success page
	And no errors should be displayed
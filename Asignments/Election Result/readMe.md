## Problem Statement

# Election Results

It's election night! Exciting! We have a feed of election results from a data supplier.
They will supply us a file which will be updated throughout the night as results come in.

A result will consist of:

- A constituency
- A repeating set of pairs with the party code and the votes cast

### So for example:

Banglore, 11014, BJP, 17803, INC, 4923, CPI, 2069, NCP
Pune, INC, 9389, CPI, 4829, BJP, 3375, NCP, 3371, BSP, 309, IND

### Party Codes -

BJP - Bhartiya Janta Party
INC - Indian National Congress
BSP - Bahujan Samaj Party
CPI - Communist Party of India
NCP - Nationalist Congress Party
IND - Independant

We want to transform this into a standard result that shows:

- the constituency name
- translates the party code into a full name
- shows the winner of the constituency

### Classes

- DataSupplier
- Election
- Party
- PartyTranslator
- ElectionResultPredictor

Behaviours

- showAllContituencyNames
- translatePartyCodeIntoFullName
- announceWinnerOfElection
- processDataFromFile

```java

class DataSupplier:

    behaviors:
        - processFileData(File file)



1)class Election :
        
        states: 
        - public String contituencyName 
        - public List<Party> votes
        behaviors:
         - getConstituencyName()

2) class Party:
    states:
        - public String partyCode
        - public int votes

    behaviors:

        - getPartyCode()
        - getNumberOfVotes()

3) class PartyTranslator

    behaviors:
        - getFullNameOfParty(String code, map<String , String> names)

4)  class ElectionResultPredictor
    - states
    - behaviors
        - annouceElectionResult(List<Election> results)

```
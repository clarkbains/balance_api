# Balance API
This is part one of 2 parts of this application. Using spring, I have a nice stable library to build this project on. 

[![forthebadge](https://forthebadge.com/images/badges/gluten-free.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-badges.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/check-it-out.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-git.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/winter-is-coming.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/you-didnt-ask-for-this.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-by-developers.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/60-percent-of-the-time-works-every-time.svg)](https://forthebadge.com)
[![](https://badgen.net/badge/website/clarkbains.com/blue.svg)](https://clarkbains.com)
[![](https://badgen.net/badge/badges/enough%20tomake%20me%20feel%20like%20a%20real%20oss%20project/blue.svg)](https://clarkbains.com)

### What does it do?
This wonderful collection of code will eventually server as an API for a kind of money-less cost sharing app. If you find yourself constantly trying to remember who owes who what among a small group of people, this is for you. 

Say we have 3 people, Barnaby, Lana and Campbell. If Barnaby goes to the store, and spends $15 on 20lbs of propane for their collective [Ruben Tube](https://www.youtube.com/watch?v=gpCquUWqaYw), then everyone, including Ruben, owes Ruben $5. Now, they could all slip some money under his doormat, but what fun is that? 

To make the problem worse, when they were hosting their weekly party, Lana bought $21 worth of fermented grape juice. Now everyone owed Lana $7 as well. 

And then, the day after, the three were hanging out, and Campbell made a giant pot of tomato soup, that cost about 6$. Everyone owes Campbell $2

Instead of constantly swapping money, this API is aimed to be the backbone of a webapp able to record, and cancel out situations where party A owes party B, and party B owes Party A. In this situation, The webapp would show 

On Lana's Dashboard
- Lana gets $2 from Barnaby
- Lana gets $5 from Campbell
  
On Barnaby's Dashboard
- Barnaby gets $3 from Campbell
- Barnaby owes $2 to Lana

On Campbell's Dashboard
- Campbell owes $3 to Barnaby
- Campbell owes $5 to Lana
  
They would then be able to request/confirm payment requests, without the hassle of constant money shuffling


### What do I like?

Some things I like about Spring and doing this project in Java:
- It can create databases by itself, from annotated classes (These are in [Database Models](/src/main/java/com/clarkbains/roommates/models/Database))
- It can generate SQL from interface method names (You'll find this in [Database Repositories](/src/main/java/com/clarkbains/roommates/models/Database/Repositories))
- Easy to do nice, readable OOP, mainly in [Responses](/src/main/java/com/clarkbains/roommates/models/Response) and  [Requests](/src/main/java/com/clarkbains/roommates/models/Request)
- Unit testing was easy to set up
---
## Running

The project was setup for vscode, you should be able to open the command pallette and run the "run" task. This will compile and build the project for you. It is aliased to running `./mvnw compile exec:java`

You may need to run `./mvnw install` to grab all the dependencies first, I have yet to test on a freshly cloned copy from github
  
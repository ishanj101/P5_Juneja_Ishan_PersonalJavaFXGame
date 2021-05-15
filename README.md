# P5_Juneja_Ishan_PersonalJavaFXGame
This is Ishan Juneja's version of Breakout Room 13 project

Commit 1: 5/12/21 Today, I focused on fixing underlying issues in the ball movement. One current problem is how the ball doesn't bounce off at certain speeds when the paddle moves. The next part I worked on was fully implementing the scores. Then I got a good start on the additions to the brick class to give the brick more health. Lastly, I started with the Power Up class and will focus on that in the coming days

Commit 2: 5/13/21 Today I continued to target the ball movement and tweaked it to not get stuck in positions after hitting the paddle but however sometimes when using the paddle to hit the ball, the ball hits the ground and makes the user lose points. The next part I focused on was the power up, I edited the power up class to add a new Class Temporary Ball I made for the power up to act like a ball but disappear after hitting the bottom of the screen and not the paddle. The place where I left off was trying to use the timer for future power ups.

Commit 3: 5/14/21 Today I worked on finishing the randomized power ups and have completed it. Bugs I was seeing was that the power up would dissapear midway through the screen and I believe I fixed this by changing the aspect ratio of the png image being used. I also finished the second power up of having an increased sized paddle but still have to implements its disappearring. I hope to add another power up next, or maybe an enemy

Commit 4: 5/15/21 Today I worked on my third power up which lights the ball on fire and deals twice as much damage to bricks.. Bugs I was seeing was that the power up would dissapear midway through the screen and I believe I fixed this by changing the aspect ratio of the png image being used once again. I found out the reason this error occurs is because the object is being modified while its being added, but even when I tweaked the program I got the same error every time. My next plan of action is put a time limit on the second two power ups. Add an enemy. Create stronger bricks. And if time permits create stage designs.

Commit 5: 5/16/21 Today I worked on setting a timer for the power ups to drop on to the screen as well as for the power ups to run out. The ball if on fire will return to its orignal form, if the paddle's size is big it will decrease, and the extra ball disapears if it goes through the bottom bound. Besides the latter the time given is approximately 9 seconds for the power up until runs out. My next plan is add an enemy. Create stronger bricks. And if time permits create stage designs or add another power up if I can think of one.

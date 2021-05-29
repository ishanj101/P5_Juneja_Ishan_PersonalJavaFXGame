# P5_Juneja_Ishan_PersonalJavaFXGame
This is Ishan Juneja's version of Breakout Room 13 project

Commit 1: 5/12/21 Today, I focused on fixing underlying issues in the ball movement. One current problem is how the ball doesn't bounce off at certain speeds when the paddle moves. The next part I worked on was fully implementing the scores. Then I got a good start on the additions to the brick class to give the brick more health. Lastly, I started with the Power Up class and will focus on that in the coming days

Commit 2: 5/13/21 Today I continued to target the ball movement and tweaked it to not get stuck in positions after hitting the paddle but however sometimes when using the paddle to hit the ball, the ball hits the ground and makes the user lose points. The next part I focused on was the power up, I edited the power up class to add a new Class Temporary Ball I made for the power up to act like a ball but disappear after hitting the bottom of the screen and not the paddle. The place where I left off was trying to use the timer for future power ups.

Commit 3: 5/14/21 Today I worked on finishing the randomized power ups and have completed it. Bugs I was seeing was that the power up would dissapear midway through the screen and I believe I fixed this by changing the aspect ratio of the png image being used. I also finished the second power up of having an increased sized paddle but still have to implements its disappearring. I hope to add another power up next, or maybe an enemy

Commit 4: 5/15/21 Today I worked on my third power up which lights the ball on fire and deals twice as much damage to bricks.. Bugs I was seeing was that the power up would dissapear midway through the screen and I believe I fixed this by changing the aspect ratio of the png image being used once again. I found out the reason this error occurs is because the object is being modified while its being added, but even when I tweaked the program I got the same error every time. My next plan of action is put a time limit on the second two power ups. Add an enemy. Create stronger bricks. And if time permits create stage designs.

Commit 5: 5/16/21 Today I worked on setting a timer for the power ups to drop on to the screen as well as for the power ups to run out. The ball if on fire will return to its orignal form, if the paddle's size is big it will decrease, and the extra ball disapears if it goes through the bottom bound. Besides the latter the time given is approximately 9 seconds for the power up until runs out. My next plan is add an enemy. Create stronger bricks. And if time permits create stage designs or add another power up if I can think of one.

Commit 6: 5/17/21 Today I worked on creating the enemy class. I had difficulties with it appearing on the screen, but through debugging I realized what caused it to not appear was an incorrectly written if condition removing the object out of the world the instance it was added. The rest of its functionality was quite simple. A feature I added to the enemy was that if it hits a brick then the brick has a 25 percent chance to strengthen. My next plan is to add different kinds of movement for the enemy, add some tweaks to make it fair for the user, and have a timer to add an enemy to the game or have a different kind of interval. Create stronger bricks. And if time permits create stage designs or add another power up if I can think of one.

Commit 7: 5/18/21 Today I worked on adding to the enemy class. I had mostly no issues but in the end while I was commit my project and all that jazz, I accidently named it fourth commit so I decided to revert the commit but this lost all my progress in eclipse so I had to go back and change everything again so though it was working pretty well originally, I am in doubt right now as well as pretty sad since I wasted a long time redoing some parts and copying it from github.  TO the enemy class I made a new movement which is more unpredictable but quite ineffective so I wil have to tweak that next time. 

Commit 8: 5/21/21 Today I worked on adding to the brick class. I made it so that the bricks have more levels/life to them with unique images for each. I also discovered the methedology I had been using when shaping images for my actors or nodes was incorrect, so I replaced it and made all the images have consistent sizes. Lastly to the enemy class I tweaked it a bit to make them appear anywhere and have a tiny bit more of a challenge. Next I feel satisfied with what I've done and the program is slowed at some points, so I think I may have reached a point of it struggling, regardless I want to add a shooting mechanic, level design, and lastly a difficult, destructive enemy.

Commit 9: 5/22/21 Today I worked on the ball bouncing off the paddle. I made the angle at which the ball bounce vary depending on what portion of the paddle it hits in order to allow for some aiming and variety. This feature only applies to the ball class and not the subclasses which override the method. This took the largest chunk of time. I want to add more fluidity to the ball bounce too so I plan on tackling that for the next time as well. Another feature which I added to the enemy class which I forgot to type was making the ball slower as well if the enemy hits the paddle to add more challenge.

Commit 10: 5/23/21 Today I worked on the ball bouncing off the paddle again. When I was working with our team, one thing we were all struggling with was trying to get the ball to bounce off correctly depending on what way the paddle moves, howver, our method didn't work and it went undetected. Now after I was editing the class I realized our error and solved the problem in the game class by finding the mouse position and the position of the paddle tofind what direction the paddle would go in. After solving this and having new improved movement a new error came up in which when the ball was hit in a certain position it would stick to the side of the wall.

Commit 11: 5/24/21 Today I worked on adding the final peices to the brick class which I was wanting to add. I added movement to the brick to move in any direction back and forth in unison to add challenge and add more engagement. The next part I worked on was adding a constructor to the ball class to have control over the ball speed. Lastly I added a life system: if the main ball hits the grounf 3 times you lose. I am still yet to add animation or graphics for it. Other than that I want to add level design and be finished.

Commit 12: 5/25/21 Today I worked on the Game Over and Winning. If the ball hits the ground 3 times, an animated "Game Over" label appears on the screen. If all the bricks are completely destroyed past level 1 then you win, and an animated label of that appears on the screen. I still don't have any other functionality past these labels as when I tried to remove the actors from the screen then I got a concurrent modification error which makes sense, but I still want the game to at lease pause. I think I might set the dx and dy of the ball to 0 so the game doesn't go on further or tweak other code to respond to the condition. My top priority now though is adding stages

Commit 13: 5/26/21 Today I worked on fixing the Game Over and Winning. From yesterday, the Game Over was working but I hadn't tested the winning pop up. After some digging, I found out I used the wrong getters and setters making it so that the condition for it to say you won wouldn't happen so I fixed that. After that I began my set up for the level design. At first I wanted to make it so clicking numbers on the keyboard would load a stage in but that lead to complications so I decided to go the safer route and use a scanner input to load a level in once in the beginning. Next, I will be working on as many stages I can as time permits.

Commit 14: 5/29/21 Today I worked on starting level design. I created a first level and added changes to the ball speed to make it easier for the user. The enemies also spawn within slower timeframes. I also tweaked the ball bouncing against the paddle more. It still isn't ideal but it is closer to my end goal.

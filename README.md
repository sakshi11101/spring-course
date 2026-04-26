# AOP Concepts in a Nutshell

### No Technical Terms, Explanation made simple! 

#### 1. Joint Point (When):- 

Think of it is as when you want to perform a certain action in movie/code. Ex: I want to do something whenever any method of service layer is being called.
**It is where the action happens.**

#### 2. Advice (What):-

What you want to happen is, advice here. For ex: with every delete and update method being called, I want to call the log method as well. **This is the action!**

#### 3. Aspect (Where-Conceptual):-

So you will create a separate class for all your cross-cutting concerns, that class/separate file where you write code to handle those concerns is called aspect.

#### 4. Pointcut (Where-Operational):- 

**Still need to understand better :) **

#### 5. Target Object (Whom):-

**This is the main character!**. Whom do you want to apply the concerns to.

#### 6. Weaving (How):-

**This is director's job!**. It is how the script (here Aspect) is turned into a movie. In Spring AOP, this happens at runtime.
Like so sometimes, actors don't know before-hand which scene is added to movie and how it is added to final movie to make a twist maybe and come to know later when watching movie (that is runtime) and maybe sometimes they know beforehand, how scenes going to add to movie (that's compile time).

#### 7. Proxy (The Double):-

**This is like a stunt done by someone else on behalf of actor in movie!**.
In Spring AOP, it's the object that is created after applying advice to the target object.

#### 8. Type of Advice (The Genre):-

In Spring AOP, there are three type of advices: Before, After, After Throwing, Around.
So to understand like, when you want to call the advice, before the target method being called, or after target method being called, or after successful or failed response etc.
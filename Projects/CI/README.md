# Continuous Integration

CI, CD and Continuous Deployment

CI - Developers practicing cont.integration merge their changes back to the main branch as often as possible. The developer's changes are validated by creating a build and running automated tests against the build. By doing so, you avoid integrations challenges theta can happen when waiting for release day to merge changes into the release branch.
CI puts a great emphasis on testing automation to check that the app is not broken whenever new commits are integrated into the main branch.

Continuos delivery - extension of continuos integration since it automatically deploys all code changes to a testing and/or production environment after the build stage.
it means, you have an automated release process and you can deploy your app any time by clicking a button. If you truly want to get the benefits of continuos delivery, you should deploy to productions as early as possible to make sure that the release small batches are easy to troubleshoot in case of problem.

Continuos deployment goes one step further than continuos delivery. Every change that passes all stages of your productions pipeline is released to your customers. There's no human interventions, and only failed test will prevent a new change to be deployed production. This is an excellent way to accelerate the feedback loop with your customers and take the pressure off the team. Developers can focus on building software, they see their work go live minutes and they've finished working on it.

Benefits:

1. You need a strong foundation on CI, test suite needs to cover enough of your codebase.
2. Deployments need to be automated. The trigger is still manual but once a deployment started there shouldn't be a need for human interventions.
3. your team most likely need to embrace feature flogs so that incomplete features do not affect customers in production.
4. The complexity of deploying software has been taken away. Your team does not to have spend days for preparing release anymore. You can release more often, thus accelerating the feedback loop with your customers. There is much less pressure on decisions of small changes.

CI cost and benefits:

1. Team will need to write automated tests for each new feature, improvement or bug fix.
2. You need a ci server that can monitor the main repo and run the tests automatically for every new commits pushed.
3. Developers need to merge their changes as often as possible, at least one a day.
4. less bugs get shipped to productions as regressions are captured early by the automated tests.
5. Building the release is easy as all integrations issues have been solved early.
6. less context switching as developers are alerted as soon as they break the build and can work on fixing it before they move to another task.
7. Testing costs are reduced drastically - your CI server can run hundreds of tests in the matter of seconds.
8. QA team spends less time testing and can focus on significant improvements to the qualify culture.

Continuos deployment costs and benefits:

1. The quality of your test suite will determine the quality of your releases.
2. Documentation process will need to keep up with the pace of deployments.
3. You can develop faster as there's no need to pause development for releases. Deployments pipelines are triggered automatically for every change.
4. Releases are less risky and easier to fix in case of problem as you deploy small batches of changes.
5. Customers see a continuos of improvements, and quality increases every day, instead of every month, quarter a year.

## Plugins in Jenkins

Enhancing the functionality of a Jenkins environment. 
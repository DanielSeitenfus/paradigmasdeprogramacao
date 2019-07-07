/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package githubanalyzergui;

/**
 *
 * @author danie
 */
public class Commit {
    //COMMIT: {"author":{"name":"DanielSeitenfus","email":"daniel.seitenfus@hotmail.com","date":"2019-07-04T01:14:21Z"},"committer":{"name":"DanielSeitenfus","email":"daniel.seitenfus@hotmail.com","date":"2019-07-04T01:14:21Z"},"message":"Create README.md","tree":{"sha":"862fa310e2f9869fb1b4f875b4213cf4f8facc41","url":"https://api.github.com/repos/DanielSeitenfus/paradigmasdeprogramacao/git/trees/862fa310e2f9869fb1b4f875b4213cf4f8facc41"},"url":"https://api.github.com/repos/DanielSeitenfus/paradigmasdeprogramacao/git/commits/8b91738611d93716e3067b140db1c4b67fbc13b1","comment_count":0,"verification":{"verified":false,"reason":"unsigned","signature":null,"payload":null}}
    //AUTHOR: {"login":"DanielSeitenfus","id":20246441,"node_id":"MDQ6VXNlcjIwMjQ2NDQx","avatar_url":"https://avatars0.githubusercontent.com/u/20246441?v=4","gravatar_id":"","url":"https://api.github.com/users/DanielSeitenfus","html_url":"https://github.com/DanielSeitenfus","followers_url":"https://api.github.com/users/DanielSeitenfus/followers","following_url":"https://api.github.com/users/DanielSeitenfus/following{/other_user}","gists_url":"https://api.github.com/users/DanielSeitenfus/gists{/gist_id}","starred_url":"https://api.github.com/users/DanielSeitenfus/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/DanielSeitenfus/subscriptions","organizations_url":"https://api.github.com/users/DanielSeitenfus/orgs","repos_url":"https://api.github.com/users/DanielSeitenfus/repos","events_url":"https://api.github.com/users/DanielSeitenfus/events{/privacy}","received_events_url":"https://api.github.com/users/DanielSeitenfus/received_events","type":"User","site_admin":false}
    String author;
    String message;
    String date;

    Commit(String message, String date, String author) {
        this.message = message;
        this.date = date;
        this.author = author;
    }
}

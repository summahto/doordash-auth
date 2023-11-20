import type { NextAuthOptions } from "next-auth";
import GitHubProvider from 'next-auth/providers/github'
import CredentialsProvider from "next-auth/providers/credentials";
import { GithubProfile } from "next-auth/providers/github";

export const options : NextAuthOptions = {
    providers : [
        GitHubProvider({
            profile(profile : GithubProfile) {
                console.log(profile);

                return {
                    ...profile,
                    role : profile.role ?? "user",
                    id: profile.id.toString(),
                    image: profile.avatar_url, 
                }
            },
            clientId : process.env.GITHUB_ID as string,
            clientSecret : process.env.GITHUB_SECRET as string
        }),
        CredentialsProvider({
            name: "Credentials",
            credentials :{
                username: {
                    label: "Username: ",
                    type: "text" ,
                    placeholder: "your cool username" 
                },
                password: {
                    label: "Password",
                    type: "password",
                    placeholder: "your-awesome-password"
                }
            },

            async authorize(credentials) {
                //this is where you need to retrieve user data to verify with the credentials
                //Docs : https://next-auth.js.org/providers/credentials
                const user = { id: "42", name : "sumit", password : "password", role : "admin"}
                const user1 = { id: "43", name : "william", password : "password", role : "manager"}
                const user2 = { id: "44", name : "amit", password : "password", role : "user"}
                
                // const userList = [
                //     { id: "42", name: "sumit", password: "password", role: "admin" },
                //     { id: "43", name: "sushant", password: "password", role: "manager" },
                //     { id: "44", name: "william", password: "password", role: "user" },
                //     { id: "45", name: "amit", password: "password", role: "user" },
                //     // Add more users as needed
                // ];

                if (credentials?.username === user.name && credentials?.password === user.password) {
                    return user
                }
                else if (credentials?.username === user1.name && credentials?.password === user1.password) {
                    return user1
                } 
                else if (credentials?.username === user2.name && credentials?.password === user2.password) {
                    return user2
                } 
                else return null
                
            },
        })
        
    ],

    callbacks : {
        // Ref: https://authjs.dev/guides/basics/role-based-access-control#persisting-the-role

        async jwt({ token, user}) {
            if (user) token.role = user.role
            return token
        },
        // if you want to use the role in client components
        async session({session, token}) {
            if (session?.user) session.user.role = token.role
            return session
            
        }
    }
}
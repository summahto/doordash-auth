// ref :https://authjs.dev/getting-started/typescript#module-augmentation

import nextAuth, { DefaultSession, DefaultUser } from "next-auth";
import { JWT, DefaultJWT } from "nextAuth/jwt"
import { decl } from "postcss";


declare module "next-auth" {
    interface Session {
        user : {
            id : string,
            role : string,
        } & DefaultSession
    }

    interface User extends DefaultUser {
        role : string
    }
}

declare module "next-auth/jwt" {
    interface JWT extends DefaultJWT {
        role : string,
    }
}

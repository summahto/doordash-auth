import Head from 'next/head'
import Layout from './layout';
import ToDoList from './customer/todo-list';

export default function Home() {
  return (
    <div>
      <Head>
        <title>Full Stack Book To Do</title>
        <meta name="description" content="Full Stack Book To Do" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Layout>
        <ToDoList />
      </Layout>
    </div>
  )
}
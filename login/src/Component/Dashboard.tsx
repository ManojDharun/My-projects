import {useParams} from 'react-router-dom';
function Dashboard(){
    const {username} = useParams<{username:string}>();
    return (
        <div>
            <h1>Hello! {username}</h1>
        </div>
    )
}

export default Dashboard;
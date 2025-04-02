import MainLayout from "./layouts/MainLayout";
import UserRegistrationForm from "./components/UserRegistrationForm"; // Aquí agregamos la importación

function App() {
    return (
        <MainLayout>
            <UserRegistrationForm/>
        </MainLayout>
    );
}

export default App;

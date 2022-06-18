import {Wrapper, ButtonWrapper, StateWrapper, Button} from './SystemState.styles'
import {useEffect, useState} from "react";
import {SystemStateItem} from "../SystemStateItem/SystemStateItem";
import axios from "axios";

export function SystemState() {
    const [systemState, updateState] = useState(null);

    useEffect(() => {
        const interval = setInterval(() => {
            axios.get(`http://localhost:8080/systemState`)
                .then((result) => {
                    console.log(result.data)
                    updateState(result.data)
                });
        }, 1000);

        return () => clearInterval(interval);
    }, []);

    function updateSystemState(id){
        axios.post(`http://localhost:8080/systemState/` + id)
            .then(result => console.log(result));
    }

    if (systemState)
        return <Wrapper>
            <ButtonWrapper>
                <Button onClick={() => updateSystemState(1)}>Active</Button>
                <Button onClick={() => updateSystemState(2)}>Sleep</Button>
                <Button onClick={() => updateSystemState(3)}>Shutdown</Button>
            </ButtonWrapper>
            <StateWrapper>
                {systemState.map(state => (
                    <SystemStateItem key={state.name} name={state.name} state={state.state}/>))}
            </StateWrapper>
        </Wrapper>

}
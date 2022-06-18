import {useEffect, useState} from "react";
import axios from "axios";
import {SensorItem} from "../SensorItem/SensorItem";
import {
    Wrapper,
    SensorStateWrapper,
    BarWrapper,
    StatWrapper
} from "./Main.styles";
import BarWave from "react-cssfx-loading/lib/BarWave";
import {MainStat} from "../MainStat/MainStat";
import {SystemState} from "../SystemState/SystemState";

export function Main() {
    const [sensors, updateSensors] = useState(null);

    useEffect(() => {
        const interval = setInterval(() => {
            axios.get(`http://localhost:8080/state`)
                .then((result) => {
                    updateSensors(result.data)
                });
        }, 1000);
        return () => clearInterval(interval);
    }, []);

    if (sensors)
        return <Wrapper>
            <SensorStateWrapper>
                {sensors.map(sensor => (
                    <SensorItem key={sensor.id} name={sensor.name} state={sensor.state}/>))}
            </SensorStateWrapper>

            <StatWrapper>
                <MainStat/>
                <SystemState/>
            </StatWrapper>
        </Wrapper>

    return <BarWrapper>
        <BarWave color="#000" width="100px" height="100px" duration="3s"/>
    </BarWrapper>
}

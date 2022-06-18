import {DataScroll, DataWrapper, Text, Wrapper} from './MainStat.styles'
import {TemperatureItem} from "../TemperatureItem/TemperatureItem";
import {HumidityItem} from "../HumidityItem/HumidityItem";
import {LightItem} from "../LightItem/LightItem";
import {useEffect, useState} from "react";
import axios from "axios";

export function MainStat() {
    const [light, updateLight] = useState(null);
    const [temperature, updateTemperature] = useState(null);
    const [humidity, updateHumidity] = useState(null);

    useEffect(() => {
        const interval = setInterval(() => {
            axios.get(`http://localhost:8080/light`)
                .then((result) => {
                    const arr = result.data;
                    updateLight(arr.reverse())
                });
        }, 1000);
        return () => clearInterval(interval);
    }, []);

    useEffect(() => {
        const interval = setInterval(() => {
            axios.get(`http://localhost:8080/temperature`)
                .then((result) => {
                    const arr = result.data;
                    updateTemperature(arr.reverse())
                });
        }, 1000);
        return () => clearInterval(interval);
    }, []);

    useEffect(() => {
        const interval = setInterval(() => {
            axios.get(`http://localhost:8080/humidity`)
                .then((result) => {
                    const arr = result.data;
                    updateHumidity(arr.reverse())
                });
        }, 1000);
        return () => clearInterval(interval);
    }, []);

    if (light && temperature && humidity)
        return <Wrapper>
            <DataWrapper>
                <Text>Temperature</Text>
                <DataScroll>
                    {temperature.map(light => (
                        <TemperatureItem value={light.value} date={light.date} time={light.time}/>))}
                </DataScroll>
            </DataWrapper>
            <DataWrapper>
                <Text>Humidity</Text>
                <DataScroll>
                    {humidity.map(light => (
                        <HumidityItem value={light.value} date={light.date} time={light.time}/>))}
                </DataScroll>
            </DataWrapper>
            <DataWrapper>
                <Text>Light</Text>
                <DataScroll>
                    {light.map(light => (
                        <LightItem value={light.value} date={light.date} time={light.time}/>))}
                </DataScroll>
            </DataWrapper>
        </Wrapper>
}
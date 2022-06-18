import {Label, Text, TextWrapper} from './SensorItem.styles'
import {CloseCircleTwoTone, CheckCircleTwoTone} from '@ant-design/icons'

export function SensorItem(props) {
    function sensorState(props) {
        const state = props;
        if (state === true) {
            return <CheckCircleTwoTone twoToneColor="#389e0d"/>;
        }
        return <CloseCircleTwoTone twoToneColor="#f5222d"/>;
    }

    return (
        <TextWrapper>
            <Label>{props.name}</Label>
            <Text>{sensorState(props.state)}</Text>
        </TextWrapper>
    );
}
import {Label, Text, TextWrapper} from './SystemStateItem.styles'
import {CloseCircleTwoTone, CheckCircleTwoTone} from '@ant-design/icons'

export function SystemStateItem(props) {

    function systemState(item) {
        const state = item;
        if (state === true) {
            return <CheckCircleTwoTone twoToneColor="#389e0d"/>;
        } else {
            return <CloseCircleTwoTone twoToneColor="#f5222d"/>;
        }
    }

    return (
        <TextWrapper>
            <Label>{props.name}</Label>
            <Text>{systemState(props.state)}</Text>
        </TextWrapper>
    );
}
// Columns for anomalies table
export default [
  {
    propertyName: 'start',
    template: 'custom/anomalies-table/start-duration',
    title: 'Start/Duration',
    className: 'anomalies-table__column anomalies-table__column--med-width',
    disableFiltering: true
  },
  {
    propertyName: 'dimensions',
    template: 'custom/anomalies-table/dimensions',
    title: 'Alert/Dimensions',
    className: 'anomalies-table__column anomalies-table__column--large-width',
    disableFiltering: true
  },
  {
    propertyName: 'baseline',
    template: 'custom/anomalies-table/current-wow',
    title: 'Current/Predicted',
    className: 'anomalies-table__column anomalies-table__column--small-width',
    disableFiltering: true
  },
  {
    propertyName: 'feedback',
    component: 'custom/anomalies-table/resolution',
    title: 'Resolution',
    className: 'anomalies-table__column anomalies-table__column--med-width',
    disableFiltering: true
  },
  {
    propertyName: 'link',
    template: 'custom/anomalies-table/investigation-link',
    title: 'Investigation',
    className: 'anomalies-table__column anomalies-table__column--small-width',
    disableFiltering: true
   }
];
